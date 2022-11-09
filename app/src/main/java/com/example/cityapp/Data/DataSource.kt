package com.example.cityapp.Data

import androidx.annotation.DrawableRes
import com.example.cityapp.R

object DataSource {
    val Category = listOf(
        "Park",
        "Restaurant"
    )

    val ParkList = listOf(
        Detail(
            imageId = R.drawable.nehru_park,
            name = "Nehru Park",
            description = "Beautiful with all student of ielts and gurunanak college student are coming there with happiness.\n" +
                    "More open with tree area."
        ),
        Detail(
            imageId = R.drawable.ektra_park,
            name = "Etra Park",
            description = "Ekta park is located in Sri Ganganagar. The atmosphere is very calm and quite. It is the best place for kids to play. As there is no disturbance and no traffic nearby. The park has so many trees and full of greenery. Because of so many plants and trees the atmosphere is clean and pollution free. You can walk here because it is such an quite place. And it is an perfect place for kids to play outdoors. Kids can play games as badminton. So it's an good place to visit."
        ),
        Detail(
            imageId = R.drawable.jagdamba_park,
            name = "Jagdamba Park",
            description = "A nice place to hang out. Usually clam and quiet. A few swings for the children to play with but mostly a neatly managed park."
        ),
        Detail(
            imageId = R.drawable.indra_vatika,
            name = "Indra Vatika",
            description = "You can go and kill some time either in the morning or in the evening. Street food stalls outside are amazing. Kids can enjoy some rides, swings. Some decent doob grass area to walk barefoo"
        )

    )

    val RestaurantList = listOf(
        Detail(
            imageId = R.drawable.tangy,
            name = "TANGY the Chinese corner",
            description = "Best club available in sri ganagangar please visit now"
        ),
        Detail(
            imageId = R.drawable.qabila,
            name = "Qabila Restaurant",
            description = "Best club available in sri ganagangar please visit now best for your money"
        ),
        Detail(
            imageId = R.drawable.anandam,
            name = "Anandam Restaurant",
            description = "Nice food and nice restaurant , must visit and taste there food"
        )
    )

}

data class Detail(
    @DrawableRes val imageId:Int,
    val name: String,
    val description: String
)