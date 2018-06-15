package app

import io.reactivex.Observable
import tornadofx.*
import ui.UsfmScreen

object Application {

    @JvmStatic fun main(args: Array<String>) {
        var db = DaggerDbComponent.create().inject()

        val str = Observable.just("hello")

        val obs1 = str.subscribe { println(it) }

        Thread.sleep(100)
        println("after the sleep")
        str.repeat()

        val obs2 = str.subscribe { println(it) }


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
