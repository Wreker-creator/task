package com.example.task

import com.example.task.model.Model1
import com.example.task.model.Model2

class Tools {

    companion object{

        val list1 = listOf<Model1>(
            Model1("", "Title1", "10"),
            Model1("", "Title2", "100"),
            Model1("", "Title3", "100"),
            Model1("", "Title4", "100"),
            Model1("", "Title5", "100"),
            Model1("", "Title6", "100"),
            Model1("", "Title7", "100"),
        )

        val list2 = listOf<Model2>(

            Model2("", "", "Channel Name", "Video title", "100", "1 month ago"),
            Model2("", "", "Channel Name", "Video title", "100", "1 month ago"),
            Model2("", "", "Channel Name", "Video title", "100", "1 month ago"),
            Model2("", "", "Channel Name", "Video title", "100", "1 month ago"),
            Model2("", "", "Channel Name", "Video title", "100", "1 month ago"),
            Model2("", "", "Channel Name", "Video title", "100", "1 month ago"),
            Model2("", "", "Channel Name", "Video title", "100", "1 month ago"),
            Model2("", "", "Channel Name", "Video title", "100", "1 month ago"),
        )

    }

}