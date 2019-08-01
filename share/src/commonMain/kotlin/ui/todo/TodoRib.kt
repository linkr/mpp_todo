package ui.todo

import mvi.RenderView
import ribs.*
import ui.root.OSDependencies
import ui.root.RouterDependencies
import utils.ui.Screen
import utils.ui.login.TodoStorage

interface TodoStorageView : RenderView<TodoStorage.TodoWish,TodoStorage.TodoState>
typealias TodoView  = Screen<TodoStorage.TodoWish,TodoStorage.TodoState>

class LoginBuilder {
    fun build(dependencies: RouterDependencies): TodoRouter {
        return TodoRouter(dependencies)
    }
}

class TodoRouter(dependencies: RouterDependencies): Router(dependencies){

    init {
        val view = dependencies.viewCreator().createView(Screen.ScreenType.Login) as TodoView
        val renderView = view.renderView as TodoStorageView
        val interactor = TodoStorage(view)
        renderView.setupPresenter(interactor)
        addInteractor(interactor)
    }
}