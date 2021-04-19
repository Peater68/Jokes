package hu.bme.aut.jokes.mock.network

import dagger.Module
import dagger.Provides
import hu.bme.aut.jokes.data.network.api.FakeApi
import hu.bme.aut.jokes.data.network.api.RealApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideFakeApi(): FakeApi = MockFakeApi()

    @Provides
    @Singleton
    fun provideRealApi(): RealApi = MockRealApi()
}