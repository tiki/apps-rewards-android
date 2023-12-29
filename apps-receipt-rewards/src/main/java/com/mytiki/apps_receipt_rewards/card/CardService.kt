package com.mytiki.apps_receipt_rewards.card

class CardService {

    val cardList = mutableListOf<Card>()

    fun addCard(list: List<Card>){
        list.forEach{
            cardList.add(it)
        }
    }
    fun getCards() = cardList.toList()

    fun removeCard(card: Card){
        cardList.remove(card)
    }
}