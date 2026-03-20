package ua.melnyk.crossplatf

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform