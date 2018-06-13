package app

import tornadofx.*
import ui.UsfmScreen

object Application {

    @JvmStatic fun main(args: Array<String>) {
        var db = DaggerDbComponent.create().inject()

        launch<UsfmScreen>(args)

//        println("hello world")
//        val bookRepo = db.getBookDao()
//        val book = Book(slug = "gen", name = "Genesis")
//        val id = bookRepo.insert(book)
//        println("id is: ${id}")
//        val ent = bookRepo.getById(id)
//        println("Book inserted is ${ent.name} with slug ${ent.slug}")

//        val api = DsmApi()
//        api.getCatalog()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.io())
//                .subscribe(
//                        {
//                            it-> println("ayy") } ,
//                        {
//                            it -> println("err")},
//                        {
//                            println("ayy complete")
//                        }
//                )
    }
}
