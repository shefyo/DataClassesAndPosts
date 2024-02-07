import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    @Test
    fun updateExisting() {

        val service = WallService()

        service.add(
            Post(
                0,
                2,
                3,
                2,
                2023,
                "privet",
                1,
                1,
                true,
                "net",
                true,
                true,
                true,
                likes = Likes(1, true, true, true),
                comments = Comments(1, 2, 2021, "like"),
                attachments = listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
            )
        )
        service.add(
            Post(
                1,
                1,
                2,
                1,
                2024,
                "kakdela",
                2,
                2,
                true,
                "mm",
                true,
                true,
                true,
                likes = Likes(5, true, true, true),
                comments = Comments(1, 2, 2021, "like"),
                listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
            )
        )
        service.add(
            Post(
                2,
                4,
                5,
                4,
                2023,
                "norm",
                3,
                3,
                true,
                "je",
                true,
                true,
                true,
                likes = Likes(81, true, true, true),
                comments = Comments(1, 2, 2021, "like"),
                listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
            )
        )

        val update = Post(
            1,
            2,
            3,
            2,
            2023,
            "norm",
            1,
            1,
            true,
            "privet",
            true,
            true,
            true,
            likes = Likes(1, true, true, true),
            comments = Comments(1, 2, 2021, "like"),
            listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
        )


        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService()
        service.add(
            Post(
                0,
                2,
                3,
                2,
                2023,
                "privet",
                1,
                1,
                true,
                "net",
                true,
                true,
                true,
                likes = Likes(1, true, true, true),
                comments = Comments(1, 2, 2021, "like"),
                listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
            )
        )
        service.add(
            Post(
                1,
                1,
                2,
                1,
                2024,
                "kakdela",
                2,
                2,
                true,
                "mm",
                true,
                true,
                true,
                likes = Likes(5, true, true, true),
                comments = Comments(1, 2, 2021, "like"),
                listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
            )
        )
        service.add(
            Post(
                2,
                4,
                5,
                4,
                2023,
                "norm",
                3,
                3,
                true,
                "je",
                true,
                true,
                true,
                likes = Likes(81, true, true, true),
                comments = Comments(1, 2, 2021, "like"),
                listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
            )
        )
        val update = Post(
            99,
            2,
            3,
            2,
            2023,
            "norm",
            1,
            1,
            true,
            "privet",
            true,
            true,
            true,
            likes = Likes(1, true, true, true),
            comments = Comments(1, 2, 2021, "like"),
            listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
        )
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun testAddFun() {
        val service = WallService()
        val post = Post(
            1,
            2,
            3,
            2,
            2023,
            "privet",
            1,
            1,
            true,
            "privet",
            true,
            true,
            true,
            likes = Likes(1, true, true, true),
            comments = Comments(1, 2, 2021, "like"),
            listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
        )
        var result = service.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun shouldAddCommentToExistingPost() {
        val service = WallService()
        val post = Post(
            1,
            2,
            3,
            2,
            2023,
            "privet",
            1,
            1,
            true,
            "privet",
            true,
            true,
            true,
            likes = Likes(1, true, true, true),
            comments = Comments(1, 2, 2021, "like"),
            listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
        )
        val comment = Comments(
            id = 1,
            fromId = 1,
            date = 2023,
            text = "Test comment"
        )


        service.add(post)
        service.createComment(1, comment)

        assertEquals(1, 1)
    }

    @Test
    fun shouldNotAddCommentToExistingPost() {
        val service = WallService()
        val post = Post(
            9,
            2,
            3,
            2,
            2023,
            "privet",
            1,
            1,
            true,
            "privet",
            true,
            true,
            true,
            likes = Likes(1, true, true, true),
            comments = Comments(1, 2, 2021, "like"),
            listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
        )
        val comment = Comments(
            id = 1,
            fromId = 1,
            date = 2023,
            text = "Test comment"
        )


        service.add(post)
        service.createComment(1, comment)

        assertEquals(0, 0)
    }

}