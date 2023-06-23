package udemy.android.newsapp

import android.os.Build
import android.util.Log
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

object MockData {
    val topNewsList = listOf<NewsData>(
        NewsData(
            1,
            R.drawable.luffypirateking,
            author = "Robin, Straw Hat News",
            title = "Luffy Finally! King of the Pirates!",
            description = "Luffy, after many trials and tribulations, has achieved his life long goal of becoming King of the Pirates! The Straw Hats are on top of the world!",
            publishedAt = "2023-05-14T07:35:21Z"
        ),
        NewsData(
            2,
            R.drawable.zorothegreatest,
            author = "Robin, Straw Hat News",
            title = "Zoro⚔️ is the G.O.A.T.🐐, Confirmed",
            description = "Zoro has fully solidified himself as the greatest swordsman to ever live. No one has ever accomplished the feats of this caliber. The Straw Hats couldn't be prouder!",
            publishedAt = "2023-05-14T08:35:21Z"
        ),
        NewsData(
            3,
            author = "Ussop, Straw Hat News",
            title = "BREAKING NEWS! Goku loses to Gon!",
            description = "An upset no one ever foresaw, the reining anime fighting champ, Goku, has lost to the up and coming, Gon, who had been on hiatus for years. His first reentry to fighting was a showy one!",
            publishedAt = "2023-05-15T09:35:21Z"
        ),
        NewsData(
            4,
            R.drawable.yorleavesspyfamily,
            author = "Chopper, Straw Hats",
            title = "Yor Claims it Had to Happen: Yor Leaves young Anya, good boy Bond, and husband Dr. Loyd",
            description = "The mild mannered Mrs. Loyd was forced to leave her happy home late last evening due to a family emergency. She fears she may not come back home. More details to come soon.",
            publishedAt = "2023-05-15T09:45:21Z"
        ),
        NewsData(
            5,
            R.drawable.loydsadlylooksoutwindow,
            author = "Sanji, Straw Hats",
            title = "Dr. Loyd is lost without the help of Wife, Yor: Loyd reflects on Yor's absence",
            description = "The unprepared claims he cannot keep his family together after the stunningly beautiful Yor was forced to leave her home last night. Will their relationship ever be the same after this turn of events?",
            publishedAt = "2023-05-15T10:35:21Z"
        ),
        NewsData(
            6,
            R.drawable.saitimaandgokumeet,
            author = "Ussop, Straw Hats",
            title = "Universal Oblivion Nearly Avoided: The Brave Ussop prevents two god-like figures from causing ultimate destruction",
            description = "In the most daring and claimed impossible negotiations ever, the brave and intelligent Ussop leads the god-like men Saitima and Kakarot (Goku) to Fight of Mass Destruction (FMD) prevention peace agreement.",
            publishedAt = "2023-05-15T11:35:21Z"
        ),
        NewsData(
            7,
            R.drawable.cheffrush,
            author = "Sanji, Straw Hats",
            title = "Chef Frush Frushie gives all the secrets to his strength: Fresh Frush Frushie Releases New Fitness and Meal Plan",
            description = "Chef Frush Frushie, known for his bigger than life biceps cutting away in The White House kitchen for the Obama family, has released a workout and diet plan regiment. A book like this from him has been in popular demand for years.",
            publishedAt = "2023-05-15T12:35:21Z"
        ),
        NewsData(
            8,
            R.drawable.milesmoraleswithcape,
            author = "Mary Jane Watson, Daily Bugle",
            title = "Spider-Hero, Araneus, proudly wears his new cape after joining the Avengers!: Avengers Induct Spider-Hero, Araneus",
            description = "The Avengers have added a long-time beloved hero to their ranks. The fashionable hero Araneus, who often teams up with his partner Spider-Man to protect New York became an Avenger today. He is over the moon with this new chapter in his career as a hero.",
            publishedAt = "2023-05-15T12:55:21Z"
        ),
        NewsData(
            9,
            R.drawable.milesvsjedi,
            author = "J. Jonah Jameson, Daily Bugle",
            title = "Araneus: The New Menace of the Avengers!",
            description = "You've heard of Spider-Man, the wall-crawling menace who has been terrorizing New York for years. But now, there's a new spider-themed hero on the scene, and he's even worse than his predecessor. His name is Araneus, and he claims to be a member of the Avengers, the so-called Earth's Mightiest Heroes.\n" +
                    "\n" +
                    "But don't let his fancy costume and high-tech gadgets fool you. Araneus is nothing but a fraud, a glory-hound, and a danger to society. He has no regard for the law, the property, or the lives of innocent people. He swings around the city, causing havoc and destruction wherever he goes. He interferes with police work, steals evidence, and assaults criminals without due process. He even has the audacity to call himself a hero, when he's really just a vigilante with a spider fetish.\n" +
                    "\n" +
                    "And what about his connection to the Avengers? How can we trust a team that welcomes such a shady character into their ranks? How can we respect a team that allows such a loose cannon to operate under their name? How can we admire a team that has been infiltrated by a spider?\n" +
                    "\n" +
                    "The answer is simple: we can't. The Avengers have lost their credibility, their integrity, and their honor. They have betrayed the public trust, and they have failed their duty as protectors of the world. They have become a menace themselves, and they must be held accountable.\n" +
                    "\n" +
                    "That's why I'm calling for a full investigation into Araneus and his ties to the Avengers. I want to know who he is, where he came from, and what he's hiding. I want to know why he chose to emulate Spider-Man, the worst superhero of all time. I want to know what his agenda is, and what he's planning to do next.\n" +
                    "\n" +
                    "And most importantly, I want him off the streets. Araneus is not a hero. He's a menace. And he must be stopped.\n",
            publishedAt = "2023-05-16T06:35:21Z"
        ),
        NewsData(
            10,
            author = "Nami, Straw Hats",
            title = "BREAKING NEWS! Gold D. Roger Lives!!!",
            description = "Luffy's celebration of being King of the Pirates as Gold D. Roger seemingly returns from the dead! Are the Straw Hats in trouble? More details to come as story develops!",
            publishedAt = "2023-05-16T07:35:21Z"
        ),
        NewsData(
            11,
            author = "Mary Jane Watson, Daily Bugle",
            title = "BREAKING NEWS! Araneus saves the Multiverse!!!",
            description = "After a clash of worlds, the heroes of Earth 2112 were able to mend the multiverse and Spider-Hero Araneus was at the center of it all. In a flash of lightning, he faced the danger of absolute oblivion in the face, mending the mega-rift of space and time.",
            publishedAt = "2023-05-17T08:35:21Z"
        ),
    )

    fun getNews(newsId: Int?): NewsData {
        return topNewsList.first { it.id == newsId }
    }

    fun Date.getTimeAgo(): String {
        val calendar = Calendar.getInstance()
        calendar.time = this

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val currentCalendar = Calendar.getInstance()
        val currentYear = currentCalendar.get(Calendar.YEAR)
        val currentMonth = currentCalendar.get(Calendar.MONTH)
        val currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH)
        val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentCalendar.get(Calendar.MINUTE)

        return when {
            year < currentYear -> {
                val interval = currentYear - year
                if (interval == 1) "a year ago" else "$interval years ago"
            }

            month < currentMonth -> {
                val interval = currentMonth - month
                if (interval == 1) "a month ago" else "$interval months ago"
            }

            day < currentDay -> {
                val interval = currentDay - day
                if (interval == 1) "a day ago" else "$interval days ago"
            }

            hour < currentHour -> {
                val interval = currentHour - hour
                if (interval == 1) "an hour ago" else "$interval hours ago"
            }

            minute < currentMinute -> {
                val interval = currentMinute - minute
                if (interval == 1) "a minute ago" else "$interval minutes ago"
            }

            else -> "a moment ago"
        }
    }

    fun stringToDate(publishedAt: String): Date {
        val instant = Instant.parse(publishedAt)
        val date = Date.from(instant)
        Log.d("published", "$date")
        return date
    }
}