package br.com.jeferson.git.challenge.ui.main

import br.com.jeferson.git.challenge.model.Item

interface OnListClickListener {
    fun onSelectItem(item: Item)
}