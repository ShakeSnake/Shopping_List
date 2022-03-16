package com.shakesnake.myapplication.domain

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun removeShopItem(shopItem: ShopItem) {
        shopListRepository.removeShopItem(shopItem)
    }


}