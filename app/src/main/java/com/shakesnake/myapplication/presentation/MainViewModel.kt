package com.shakesnake.myapplication.presentation


import androidx.lifecycle.ViewModel
import com.shakesnake.myapplication.data.ShopListRepositoryImpl
import com.shakesnake.myapplication.domain.EditShopItemUseCase
import com.shakesnake.myapplication.domain.GetShopListUseCase
import com.shakesnake.myapplication.domain.RemoveShopItemUseCase
import com.shakesnake.myapplication.domain.ShopItem


class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun removeShopItem(shopItem: ShopItem) {
        removeShopItemUseCase.removeShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}