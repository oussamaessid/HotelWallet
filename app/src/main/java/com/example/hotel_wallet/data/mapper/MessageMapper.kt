package com.example.hotel_wallet.data.mapper

import com.example.hotel_wallet.data.model.MessageDto
import com.example.hotel_wallet.domain.model.Message
import javax.inject.Inject

class MessageMapper @Inject constructor() :
    BaseMapper<MessageDto, Message> {
    override fun map(from: MessageDto): Message {
        return Message(
            message = from.message
        )
    }

    override fun mapInverse(from: Message): MessageDto {
        return MessageDto(
            message = from.message
        )
    }
}