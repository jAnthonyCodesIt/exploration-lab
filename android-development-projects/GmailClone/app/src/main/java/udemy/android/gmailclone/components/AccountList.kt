package udemy.android.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import udemy.android.gmailclone.R
import udemy.android.gmailclone.accountList
import udemy.android.gmailclone.model.AccountData

@Composable
fun AccountList(paddingValues: PaddingValues, scrollState: ScrollState) {
    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
                .scrollable(scrollState, orientation = Orientation.Vertical)
        ) {
            items(accountList) { accountData ->
                AccountItem(accountData = accountData)
            }
        }
    }

}

@Composable
fun AccountItem(accountData: AccountData, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Card(
            modifier = modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape),
            backgroundColor = Color.Gray
        ) {
            if (accountData.icon != null) {
                Image(
                    painter = painterResource(id = accountData.icon),
                    contentDescription = "${accountData.userName} Icon"
                )
            }
            Text(
                text = accountData.userName[0].toString(),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Column(modifier.weight(2.0f).padding(top = 6.dp)) {
            Text(
                text = accountData.userName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = accountData.email,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column {
            Text(
                text = if (accountData.unreadEmails > 99) "99+" else "${accountData.unreadEmails}",
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountItemPreview() {
    AccountItem(
        AccountData(
            icon = R.drawable.superdevsatlanta,
            accountId = 0,
            userName = "Super Devs Atlanta",
            email = "superdevatlanta@atl.com",
            unreadEmails = 50
        )
    )
    AccountItem(
        AccountData(
            accountId = 1,
            userName = "Jackie",
            email = "jackie@gmail.com",
            unreadEmails = 50
        )
    )
}