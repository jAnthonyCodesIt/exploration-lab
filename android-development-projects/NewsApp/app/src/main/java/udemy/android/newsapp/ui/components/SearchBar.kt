package udemy.android.newsapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import udemy.android.newsapp.network.Api
import udemy.android.newsapp.network.NewsManager
import udemy.android.newsapp.ui.MainViewModel


@Composable
fun SearchBar(query: MutableState<String>, viewModel: MainViewModel) {
    val localFocusManager = LocalFocusManager.current

    Card(
        elevation = 6.dp, shape = RoundedCornerShape(4.dp), modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        TextField(
            value = query.value,
            onValueChange = {
                query.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = {
                Text(text = "Search", color = Color.White)
                    },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ) ,
            leadingIcon = {
                Icon(Icons.Filled.Search, tint = Color.White, contentDescription = "")
            },
            trailingIcon = {
                if (query.value.isNotEmpty()) {
                    IconButton(onClick = {
                        query.value = ""
                        localFocusManager.clearFocus()
                    }) {
                        Icon(Icons.Default.Close, tint = Color.White, contentDescription = "")
                    }
                }
            },
            textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
            keyboardActions = KeyboardActions(
                onSearch = {
                    if (query.value.isNotEmpty()) {
                        viewModel.getSearchedArticles(query.value)
                    }
                    localFocusManager.clearFocus()
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
            )

        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(query = mutableStateOf(""), viewModel())
}