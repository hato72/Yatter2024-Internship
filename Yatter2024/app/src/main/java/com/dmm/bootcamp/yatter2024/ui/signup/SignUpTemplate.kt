package com.dmm.bootcamp.yatter2024.ui.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmm.bootcamp.yatter2024.ui.login.LoginTemplate
import com.dmm.bootcamp.yatter2024.ui.theme.Yatter2024Theme

//class SignUpTemplate {
//}

@Composable
fun SignUpTemplate(
    userName: String,
    onChangedUserName: (String) -> Unit,
    password: String,
    onChangedPassword: (String) -> Unit,
    isEnableSignUp: Boolean,
    isLoading: Boolean,
    onClickLogin: () -> Unit,
    onClickRegister: () -> Unit,
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "新規登録")
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp),
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    text = "ユーザー名"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = userName,
                    onValueChange = onChangedUserName,
                    placeholder = {
                        Text(text = "username")
                    },
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "パスワード"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = password,
                    onValueChange = onChangedPassword,
                    placeholder = {
                        Text(text = "password")
                    },
                )

                Button(
                    enabled = isEnableSignUp,
                    onClick = onClickRegister,
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(text = "新規登録")
                }

                Divider(modifier = Modifier.padding(vertical = 16.dp))

                Text(
                    text = "登録済みの方は",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2
                )
                TextButton(
                    onClick = onClickLogin,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "ログイン")
                }
            }

            if (isLoading){
                CircularProgressIndicator()
            }
        }
    }
}

@Preview
@Composable
private fun SignUpTemplatePreview() {
    Yatter2024Theme {
        Surface() {
            SignUpTemplate(
                userName = "username",
                onChangedUserName = {},
                password = "password",
                onChangedPassword = {},
                isEnableSignUp = true,
                isLoading = false,
                onClickLogin = {},
                onClickRegister = {},
            )
        }
    }
}
