package problems.t2353

import java.util.PriorityQueue

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    private val cuisineMap = HashMap<String, PriorityQueue<Food>>()
    private val foodMap = HashMap<String, Food>()

    init {
        for (i in foods.indices) {
            val name = foods[i]
            val cuisine = cuisines[i]
            val rating = ratings[i]
            cuisineMap.getOrPut(cuisine) { PriorityQueue() }.add(Food(name, cuisine, rating))
            foodMap[name] = Food(name, cuisine, rating)
        }
    }

    fun changeRating(name: String, newRating: Int) {
        val food = foodMap[name]!!
        food.rating = newRating
        cuisineMap[food.cuisine]!!.offer(Food(name, food.cuisine, newRating))
    }

    fun highestRated(cuisine: String): String {
        val pq = cuisineMap[cuisine]!!
        while (pq.peek().rating != foodMap[pq.peek().name]!!.rating) pq.poll()
        return pq.peek().name
    }

    companion object {
        private class Food(val name: String, val cuisine: String, var rating: Int) : Comparable<Food> {
            override fun compareTo(other: Food): Int {
                if (this.rating == other.rating) {
                    return this.name.compareTo(other.name)
                }
                return this.rating.compareTo(other.rating) * -1
            }
        }
    }
}
