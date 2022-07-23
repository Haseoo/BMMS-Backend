package com.github.haseoo.bmms.service.implementation

import com.github.haseoo.bmms.domain.OrderList
import com.github.haseoo.bmms.domain.OrderPosition
import com.github.haseoo.bmms.exception.NotFoundException
import com.github.haseoo.bmms.repository.adapter.OrderListRepositoryPort
import com.github.haseoo.bmms.service.OrderListService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class OrderListServiceImpl(val orderListRepositoryPort: OrderListRepositoryPort) : OrderListService {
    override fun getOrderLists(): Collection<OrderList> = orderListRepositoryPort.findAll()

    override fun getOrderListById(orderListId: Long): OrderList =
        orderListRepositoryPort.findById(orderListId) ?: throw NotFoundException("OrderList", orderListId)

    @Transactional
    override fun addOrderList(orderList: OrderList): OrderList {
        orderList.lastModification = LocalDateTime.now()
        return orderListRepositoryPort.save(orderList)
    }

    override fun updateOrderList(orderList: OrderList) {
        val existingList = getOrderListById(orderList.id!!)
        existingList.name = orderList.name
        existingList.lastModification = LocalDateTime.now()
        orderListRepositoryPort.save(existingList)
    }

    @Transactional
    override fun deleteOrderList(orderListId: Long) = orderListRepositoryPort.delete(getOrderListById(orderListId))

    @Transactional
    override fun addOrderListPosition(orderListId: Long, offerId: Long, orderPosition: OrderPosition) {
        val orderList = getOrderListById(orderListId)
        val existingPosition = orderList.positions.find { it.offer.id == offerId }
        existingPosition?.let { existingPosition.quantity += orderPosition.quantity }
            ?: run { orderList.positions += orderPosition }
        orderList.lastModification = LocalDateTime.now()

    }

    @Transactional
    override fun updateOrderListPosition(orderListId: Long, offerId: Long, orderListPosition: OrderPosition) {
        val existingPosition = getOrderListById(orderListId).positions.find { it.id == orderListId }
            ?: throw NotFoundException("Order position", orderListPosition.id!!)
        existingPosition.quantity = orderListPosition.quantity
    }

    @Transactional
    override fun deleteOrderListPosition(orderListId: Long, orderListPositionId: Long) {
        val orderList = getOrderListById(orderListId)
        orderList.positions -= orderList.positions.find { it.id == orderListId }
            ?: throw NotFoundException("Order position", orderListPositionId)
    }
}