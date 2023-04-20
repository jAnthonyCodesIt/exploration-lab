package udemy.android.gmailclone.model

import android.graphics.drawable.Icon

class AccountData(
    val icon: Int? = null,
    val accountId: Int,
    val userName: String,
    val email: String,
    val unreadEmails: Int
)