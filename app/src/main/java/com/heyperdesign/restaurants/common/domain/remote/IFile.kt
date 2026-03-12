package com.heyperdesign.restaurants.common.domain.remote

import com.heyperdesign.restaurants.common.data.repository.remote.File

interface IFile {
    val name: String
    val value: ByteArray
    val mimType: File.MimeTypeInfo
    val size: Int
}