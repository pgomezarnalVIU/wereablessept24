package com.example.musicdb.data.utils

import com.example.musicdb.data.Music


private val booksList: MutableList<Music> = mutableListOf(
    Music(id = 1, title = "Catch-22", author = "Joeseph Heller", read = true),
    Music(id = 2, title = "To Kill A Mockingbird", author = "Harper Lee", read = true),
    Music(id = 3, title = "A Tale Of Two Cities", author = "Charles Dickens", read = false),
    Music(
        id = 4,
        title = "On The Origin Of Species",
        author = "Charles Darwin",
        read = false,
        bookType = NonFiction
    ),
    Music(
        id = 5,
        title = "A Brief History Of TIme",
        author = "Stephen Hawkins",
        read = true,
        bookType = NonFiction
    ),
)

fun getMusic(orderBy: SortOrder): List<Music> {
    return when(orderBy) {
        SortByAuthor -> booksList.sortedBy { it.author }
        SortByFictional -> booksList.sortedBy { it.bookType == Fiction }
        SortByRead -> booksList.sortedBy { it.read }
        SortByTitle -> booksList.sortedBy { it.title }
    }
}

fun addOrUpdateBook(book: BookVM) {
    val existingBook = booksList.find { it.id == book.id }

    existingBook?.let {
        booksList.remove(it)
    }
    booksList.add(book)

}

fun deleteBook(book: BookVM) {
    booksList.remove(book)
}


