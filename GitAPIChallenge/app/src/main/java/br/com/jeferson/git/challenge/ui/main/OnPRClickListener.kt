package br.com.jeferson.git.challenge.ui.main

import br.com.jeferson.git.challenge.model.Item
import br.com.jeferson.git.challenge.model.PRItem

interface OnPRClickListener {
    fun onSelectItem(item: PRItem)
}