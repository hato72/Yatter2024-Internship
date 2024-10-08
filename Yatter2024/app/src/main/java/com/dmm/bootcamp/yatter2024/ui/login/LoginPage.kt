package com.dmm.bootcamp.yatter2024.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dmm.bootcamp.yatter2024.ui.LocalNavController
import com.dmm.bootcamp.yatter2024.ui.signup.SignUpUiState
import com.dmm.bootcamp.yatter2024.ui.signup.SignUpViewModel
import org.koin.androidx.compose.getViewModel

//class LoginPage {
//}

@Composable
fun LoginPage(
    viewModel: LoginViewModel = getViewModel()
) {
    val uiState: LoginUiState by viewModel.uiState.collectAsStateWithLifecycle()
    //val uiStateSign: SignUpUiState by signviewModel.uiStateSign.collectAsStateWithLifecycle()
    
    LoginTemplate(
        userName = uiState.loginBindingModel.username,
        onChangedUserName = viewModel::onChangedUsername,
        password = uiState.loginBindingModel.password,
        onChangedPassword = viewModel::onChangedPassword,
        isEnableLogin = uiState.isEnableLogin,
        isLoading = uiState.isLoading,
        onClickLogin = viewModel::onClickLogin,
        onClickRegister = viewModel::onClickRegister,
    )

    val destination by viewModel.destination.collectAsStateWithLifecycle()
    val navController = LocalNavController.current
    LaunchedEffect(destination)  {
        destination?.let {
            it.navigate(navController)
            viewModel.onCompleteNavigation()
        }
    }
}