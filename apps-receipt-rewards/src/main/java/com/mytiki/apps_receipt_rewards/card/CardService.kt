package com.mytiki.apps_receipt_rewards.card

class CardService {

    val cardList = mutableListOf<Card>()

    fun addCard(vararg cards: Card){
        cards.forEach {
            cardList.add(it)
        }
    }

    fun addCard(list: List<Card>){
        list.forEach{
            cardList.add(it)
        }
    }

    fun removeCard(card: Card){
        cardList.remove(card)
    }
}