package com.example.hotelwallet.data.repository

import android.util.Log
import com.example.hotelwallet.data.mapper.LoginMapper
import com.example.hotelwallet.data.mapper.MessageMapper
import com.example.hotelwallet.data.model.MessageDto
import com.example.hotelwallet.data.model.SignUpListResponse
import com.example.hotelwallet.data.model.UserListResponse
import com.example.hotelwallet.data.source.remote.Api
import com.example.hotelwallet.domain.model.Login
import com.example.hotelwallet.domain.model.Message
import com.example.hotelwallet.domain.model.SignUp
import com.example.hotelwallet.domain.model.User
import com.example.hotelwallet.domain.repository.LoginRepository
import com.example.hotelwallet.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: Api,
    private val loginMapper: LoginMapper,
    private val messageMapper: MessageMapper
) : LoginRepository {

    override suspend fun getLogin(email: String, password: String): Flow<Resource<UserListResponse>> = flow{
        val credentials = Login(email, password)
        val response =  api.login(credentials)
        Log.println(Log.ASSERT,"Response",response.toString())

        try {
            emit(Resource.Loading)
            if (response.body()?.status != null) {
                val body = response.body()
                Log.println(Log.ASSERT,"LoginResponse",body.toString())
                if (body != null) {
                    emit(Resource.Success(body))
                }
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

    override suspend fun signUp(name: String, email: String, password: String): Flow<Resource<MessageDto>> = flow {
        val credentials = SignUp(name,email, password)
        val response = api.signUp(credentials)
        Log.println(Log.ASSERT, "regResponse", response.toString())

        try {
            emit(Resource.Loading)
            if (response.body()?.message != null) {
                val signUpResponse = response.body()
                Log.println(Log.ASSERT, "registerResponse", response.body().toString())
                if (signUpResponse != null) {
                    emit(Resource.Success(signUpResponse))
                }
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

}
