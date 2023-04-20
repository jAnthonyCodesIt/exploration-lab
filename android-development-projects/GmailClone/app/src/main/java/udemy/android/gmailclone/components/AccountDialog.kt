package udemy.android.gmailclone.components

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import udemy.android.gmailclone.R
import udemy.android.gmailclone.accountList

@Composable
fun AccountDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(
            dismissOnClickOutside = false
        )
    ) {
        AccountDialogUI(openDialog = openDialog)
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>) {
    Card() {
        Column(modifier.background(MaterialTheme.colors.background).padding(bottom = 12.dp)) {
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    openDialog.value = false
                }) {
                    Icon(Icons.Default.Close, "Close button")
                }
                Image(
                    painterResource(R.drawable.google_logo), "Google logo", modifier.size(30.dp).weight(2.0f)
                )
            }
            AccountItem(accountData = accountList[0])
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, Color.Gray)
                ) {
                    Text(
                        text = "Google Account",
                        modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(
                    modifier.width(10.dp)
                )
            }
            Divider(
                modifier.padding(top = 16.dp)
            )
            Column {
                AccountItem(accountList[1])
                AccountItem(accountList[2])
            }
            AddAccount(Icons.Default.PersonAddAlt, "Add another Account")
            AddAccount(Icons.Outlined.ManageAccounts, "Manage Accounts on this device")
            Divider(Modifier.padding(vertical = 12.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Text("Privacy Policy")
                Card(
                    Modifier
                        .padding(top = 10.dp)
                        .size(3.dp),
                    CircleShape,
                    backgroundColor = Color.Black
                ) {  }
                Text("Terms Of Service")
            }
//            AccountList(PaddingValues(2.dp), scrollState)
        }
    }
}

@Composable
fun AddAccount(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
    ) {
        IconButton(onClick = {/*TODO*/}) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
        }
        Text(text = title, fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp))
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AccountDialogPreview() {
    AccountDialogUI(openDialog = mutableStateOf(value = false))
}