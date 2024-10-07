package com.knowledgespike.books.utils

sealed class Screen (val route: String){
    data object BooksListScreen : Screen("books_list_screen")
    data object AddEditBooksScreen : Screen("add_edit_book_screen")
}