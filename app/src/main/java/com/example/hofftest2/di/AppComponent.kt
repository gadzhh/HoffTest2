package com.example.hofftest2.di

import android.content.Context
import com.example.hofftest2.App
import com.example.hofftest2.presentation.activity.MainActivity
import com.example.hofftest2.presentation.detail.ui.DetailFragment
import com.example.hofftest2.presentation.order.ui.OrderFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        OrdersModule::class,
        DetailModule::class,
        SchedulersModule::class,
        NavigationModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun inject(oFragment: OrderFragment)
    fun inject(orders: OrdersModule)
    fun inject(dFragment: DetailFragment)
    fun inject(detail: DetailModule)
    fun inject(main: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}
