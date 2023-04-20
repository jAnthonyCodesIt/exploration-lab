package udemy.android.gmailclone

import android.graphics.drawable.Icon
import androidx.compose.material.Icon
import udemy.android.gmailclone.model.AccountData
import udemy.android.gmailclone.model.MailData

//Mock data generated with teh help of Chat GPT
val mailList = listOf(
    MailData(
        mailId = 1,
        userName = "Jordan",
        subject = "OWASP Top 10 Vulnerabilities",
        body = "If you don't know, now you know. Here are the top ten security vulnerabilities to look out for:\n1. Injection\n2. Broken Authentication and Session Management\n3. Cross-Site Scripting (XSS)\n4. Broken Access Control\n5. Security Misconfiguration\n6. Insecure Cryptographic Storage\n7. Insufficient Transport Layer Protection\n8. Insecure Communications\n9. Failure to Restrict URL Access\n10. Insufficient Authentication/Authorization",
        timeStamp = "21:00"
    ),
    MailData(
        mailId = 2,
        userName = "John",
        subject = "Important Security Update",
        body = "Please update your system immediately to patch the latest security vulnerabilities.",
        timeStamp = "09:30"
    ),
    MailData(
        mailId = 3,
        userName = "Mary",
        subject = "Project Deadline Approaching",
        body = "Just a reminder that the deadline for the project is in 2 weeks. Please make sure everything is on track.",
        timeStamp = "14:15"
    ),
    MailData(
        mailId = 4,
        userName = "Alex",
        subject = "Networking Event",
        body = "Don't forget to RSVP for the upcoming networking event. It's a great opportunity to make new connections.",
        timeStamp = "16:45"
    ),
    MailData(
        mailId = 5,
        userName = "Jordan",
        subject = "Reminder: Team Meeting Tomorrow",
        body = "Just a friendly reminder that we have a team meeting tomorrow at 10am. See you there!",
        timeStamp = "19:30"
    ),
    MailData(
        mailId = 6,
        userName = "Sarah",
        subject = "New Project Proposal",
        body = "I have a new project proposal that I would like to discuss with you. Let me know if you have some time this week.",
        timeStamp = "11:20"
    ),
    MailData(
        mailId = 7,
        userName = "David",
        subject = "Product Launch",
        body = "We're getting ready to launch our new product. Please make sure you're prepared for the launch.",
        timeStamp = "08:10"
    ),
    MailData(
        mailId = 8,
        userName = "Emma",
        subject = "Reminder: Company Picnic",
        body = "Don't forget to RSVP for the company picnic next weekend. We're looking forward to a fun day out!",
        timeStamp = "12:45"
    ),
    MailData(
        mailId = 9,
        userName = "Jordan",
        subject = "Project Update",
        body = "Just wanted to give you a quick update on the project. We're making good progress and should be done on time.",
        timeStamp = "10:00"
    ),
    MailData(
        mailId = 10,
        userName = "Alex",
        subject = "Job Opening",
        body = "We have a new job opening at the company. Please let me know if you're interested.",
        timeStamp = "15:20"
    ),
    MailData(
        mailId = 11,
        userName = "Mary",
        subject = "Vacation Request",
        body = "I would like to request some time off for vacation. Please let me know what the procedure is.",
        timeStamp = "17:00"
    ),
    MailData(
        mailId = 12,
        userName = "John",
        subject = "Important Client Meeting",
        body = "We have an important meeting with our stakeholders today at 17:00. Make sure to have that presentation ready.",
        timeStamp = "13:00"
    ),
    MailData(
        mailId = 13,
        userName = "Alice",
        subject = "New Policy Updates",
        body = "Hi everyone, we have made some updates to our company policies. Please review them at your earliest convenience and let me know if you have any questions.",
        timeStamp = "11:20"
    ),
    MailData(
        mailId = 14,
        userName = "Chris",
        subject = "Client Meeting Follow-Up",
        body = "Thanks to everyone who attended yesterday's client meeting. Please review the notes and action items that were sent out and let's make sure we follow up on everything as needed.",
        timeStamp = "14:50"
    ),
    MailData(
        mailId = 15,
        userName = "Olivia",
        subject = "IT Support Request",
        body = "Hi IT team, I'm having trouble with my computer and I need some assistance. Can someone please come by my desk when you have a chance?",
        timeStamp = "09:10"
    ),
    MailData(
        mailId = 16,
        userName = "Ryan",
        subject = "Happy Hour Plans",
        body = "Hey everyone, let's meet up for happy hour after work today at the bar down the street. Hope to see you all there!",
        timeStamp = "16:05"
    ),
    MailData(
        mailId = 17,
        userName = "Amanda",
        subject = "Expense Report Submission Reminder",
        body = "Just a reminder that all expense reports for the previous quarter are due by the end of the week. Please make sure to submit them on time to avoid any delays in reimbursement.",
        timeStamp = "13:45"
    ),
    MailData(
        mailId = 18,
        userName = "Eric",
        subject = "Upcoming Business Trip",
        body = "Hi team, just wanted to let you know that I will be going on a business trip next week. I'll be out of office from Monday to Wednesday, but I'll be available via email and phone during that time.",
        timeStamp = "08:00"
    ),
    MailData(
        mailId = 19,
        userName = "Sophia",
        subject = "Reminder: Employee Survey",
        body = "Just a reminder to complete the employee survey if you haven't done so already. Your feedback is important to us and will help us make improvements to our workplace.",
        timeStamp = "10:30"
    ),
    MailData(
        mailId = 20,
        userName = "Brandon",
        subject = "Job Opening: Data Analyst",
        body = "Hi everyone, we're currently looking for a Data Analyst to join our team. If you or anyone you know might be interested, please check out the job listing on our website.",
        timeStamp = "12:20"
    ),
    MailData(
        mailId = 21,
        userName = "Mia",
        subject = "Training Session Feedback",
        body = "Thanks to everyone who attended yesterday's training session. Please take a few minutes to complete the feedback form and let us know how we can improve for future sessions.",
        timeStamp = "16:30"
    ),
    MailData(
        mailId = 22,
        userName = "Connor",
        subject = "Company Anniversary Celebration",
        body = "Hey everyone, just a reminder that our company anniversary celebration will be next Friday at 3pm in the cafeteria. There will be food, drinks, and a few surprises!",
        timeStamp = "09:15"
    )

)

val accountList = listOf(
    AccountData(
        icon = R.drawable.superdevsatlanta,
        accountId = 0,
        userName = "Super Devs Atlanta",
        email = "superdevsatlanta@atl.com",
        unreadEmails = 150
    ),
    AccountData(
        accountId = 1,
        userName = "Jordan",
        email = "jordan107@gmail.com",
        unreadEmails = 150
    ),
    AccountData(
        accountId = 2,
        userName = "James",
        email = "james107@gmail.com",
        unreadEmails = 10
    ),
    AccountData(
        accountId = 3,
        userName = "Jackie",
        email = "jackie107@gmail.com",
        unreadEmails = 50
    ),
    AccountData(
        accountId = 4,
        userName = "Jaylina",
        email = "jaylina107@gmail.com",
        unreadEmails = 20
    )
)