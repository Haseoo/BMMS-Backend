package com.github.haseoo.bmms.service

import com.github.haseoo.bmms.domain.OrderList
import com.github.haseoo.bmms.domain.OrderPosition

interface OrderListService {

    fun getOrderLists(): Collection<OrderList>

    fun getOrderListById(orderListId: Long): OrderList

    fun addOrderList(orderList: OrderList): OrderList

    fun updateOrderList(orderList: OrderList)

    fun deleteOrderList(orderListId: Long)

    fun addOrderListPosition(orderListId: Long, offerId: Long, orderPosition: OrderPosition)

    fun updateOrderListPosition(orderListId: Long, offerId: Long, orderListPosition: OrderPosition)

    fun deleteOrderListPosition(orderListId: Long, orderListPositionId: Long)

}