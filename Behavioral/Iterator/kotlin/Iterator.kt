/**
 * This is a real world example of a social media app, it shows how can the Iterator design pattern
 * help you implement the messaging feature.
 * */

/**
 * An iterator allows to sequentially access the elements without exposing its
 * internal structure .e.g. whether it's a list or a map.
 * */
interface Iterator<out T> {
    /**
     * Returns the next element in the iteration.
     */
    fun next(): T

    /**
     * Returns `true` if the iteration has more elements.
     */
    fun hasNext(): Boolean
}

/**
 * An iterable object should craft its own *Iterator* implementation.
 * */
interface Iterable<out T> {
    fun iterator(): Iterator<T>
}

/**
 * A simple message object that only contains text
 * */
data class MessageObject(
    val messageId: String,
    val senderId: String,
    val text: String
)

/**
 * A Conversation between 2 or more people that holds an immutable list of messages.
 * */
class Conversation(
    val conversationId: String,
    val messages: List<MessageObject>
) : Iterable<MessageObject> {
    override fun iterator(): Iterator<MessageObject> =
        ConversationIter()

    inner class ConversationIter :
        Iterator<MessageObject> {
        private var cursor =
            0

        override fun next(): MessageObject {
            return try {
                this@Conversation.messages[cursor++]
            } catch (e: IndexOutOfBoundsException) {
                throw NoSuchElementException(
                    e
                )
            }
        }

        override fun hasNext(): Boolean =
            cursor < this@Conversation.messages.size
    }
}

/**
 * A ConversationManager is an object used to store conversation objects and provide an interface to retrieve,
 * delete and store more conversations.
 * */
class ConversationManager :
    Iterable<Conversation> {
    private val conversationLookup =
        HashMap<String, Conversation>()

    fun putConversation(
        conversationId: String,
        messages: List<MessageObject>
    ) {
        conversationLookup[conversationId] =
            Conversation(
                conversationId,
                messages
            )
    }

    fun getConversation(
        conversationId: String
    ): Conversation? =
        conversationLookup[conversationId]

    fun deleteConversation(
        conversationId: String
    ) {
        conversationLookup.remove(
            conversationId
        )
    }

    /**
     * Bind a messageObject to a conversation if it exists.
     * */
    fun bindMessageObject(
        messageObject: MessageObject,
        conversationId: String
    ) {
        val beforeConversation =
            conversationLookup[conversationId]
        if (beforeConversation != null) {
            val messages =
                beforeConversation.messages.toMutableList()
            messages.add(
                messageObject
            )
            val afterConversation =
                Conversation(
                    conversationId,
                    messages
                )
            conversationLookup[conversationId] =
                afterConversation
        }
    }

    override fun iterator(): Iterator<Conversation> =
        ConversationListIter()

    inner class ConversationListIter :
        Iterator<Conversation> {
        private var cursor =
            0

        override fun next(): Conversation {
            return try {
                this@ConversationManager.conversationLookup.values.toList()[cursor]
            } catch (e: IndexOutOfBoundsException) {
                throw NoSuchElementException(
                    e
                )
            }
        }

        override fun hasNext(): Boolean =
            cursor < this@ConversationManager.conversationLookup.values.size

    }
}


/**
 * The Entry point of the program
 * @param args the arguments passed in the terminal
 * */
fun main(
    args: Array<String>
) {
    val message1 =
        MessageObject(
            "123",
            "321",
            "Hello, How are you?"
        )
    val message2 =
        MessageObject(
            "741",
            "123",
            "I'm fine, you?"
        )
    val message3 =
        MessageObject(
            "213",
            "321",
            "good!"
        )
    val conversationManager =
        ConversationManager()
    conversationManager.putConversation(
        "202",
        listOf(
            message1,
            message2,
            message3
        )
    )

    val allConversationsIterator =
        conversationManager.iterator()
    val firstConversation =
        allConversationsIterator.next()

    val messagesIterator =
        firstConversation.iterator()

    var i = 0
    while (messagesIterator.hasNext()) {
        val message =
            messagesIterator.next()
        println(
            "Message ${i++}: ${message.text}"
        )
    }

}