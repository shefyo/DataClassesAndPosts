data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Long,
    val text: String?,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val copyright: String,
    val canPin: Boolean,
    val canEdit: Boolean?,
    val canDelete: Boolean?,
    var likes: Likes,
    val comments: Comments?,
    val attachments: List<Attachment>
)

abstract class Attachment(val type: String)

class PhotoAttachment(
    type: String,
    val photo: Photo
) : Attachment(type)

class VideoAttachment(
    type: String,
    val video: Video
) : Attachment(type)

class AudioAttachment(
    type: String,
    val audio: Audio
) : Attachment(type)

class DocumentAttachment(
    type: String,
    val document: Document
) : Attachment(type)

class LinkAttachment(
    type: String,
    val link: Link
) : Attachment(type)

class Photo(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
)

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String
)

class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int
)

class Link(
    val url: String,
    val title: String
)


data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)


class WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1
    fun add(post: Post): Post {
        post.id = nextId
        nextId++
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        if (index != -1) {
            posts[index] = post
            return true
        }
        return false
    }
}

fun main() {
    var post1 = Post(
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
        comments = Comments(5, true, true, true, true),
        attachments = listOf(AudioAttachment("audio", Audio(1, 25, "Oleg", "privet")))
    )
}