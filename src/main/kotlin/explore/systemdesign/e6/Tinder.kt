package explore.systemdesign.e6

class Tinder() {
    private val interests = mutableListOf<String>()
    private val interestIdMap = mutableMapOf<String, Int>()
    private val userMap = mutableMapOf<Int, User>()

    fun signup(
        userId: Int,
        gender: Int,
        preferredGender: Int,
        age: Int,
        minPreferredAge: Int,
        maxPreferredAge: Int,
        userInterests: List<String>
    ) {
        val interestIds = handleSignupInterests(userInterests)
        val user = User(
            userId,
            gender,
            preferredGender,
            age,
            minPreferredAge,
            maxPreferredAge,
            interestIds
        )
        userMap[userId] = user
    }

    fun getMatches(userId: Int): List<Int> {
        return userMap[userId]?.let { user ->
            userMap.values
                .asSequence()
                .filter { u ->
                    u.userId != user.userId
                        && u.gender == user.preferredGender
                        && u.age in user.minPreferredAge..user.maxPreferredAge
                }
                .map { u ->
                    val commonInterestCount = user.interests.intersect(u.interests).size
                    UserWithCommonInterests(u.userId, commonInterestCount)
                }
                .filter { it.commonInterestCount > 0 }
                .sortedWith(
                    Comparator.comparingInt<UserWithCommonInterests?> { it.commonInterestCount }.reversed()
                        .thenComparingInt { it.userId })
                .map { u -> u.userId }
                .take(5)
                .toList()
        } ?: listOf()
    }

    private fun handleSignupInterests(userInterests: List<String>): Set<Int> {
        return userInterests.map { interest ->
            interestIdMap[interest] ?: run {
                val interestId = interests.size
                interestIdMap[interest] = interestId
                interests.add(interest)
                interestId
            }
        }.toSet()
    }

    private data class User(
        val userId: Int,
        val gender: Int,
        val preferredGender: Int,
        val age: Int,
        val minPreferredAge: Int,
        val maxPreferredAge: Int,
        val interests: Set<Int>
    )

    private data class UserWithCommonInterests(
        val userId: Int,
        val commonInterestCount: Int,
    )
}

