package com.example.upeers

import androidx.room.*

@Entity
data class Course(
    @PrimaryKey val indexNumber: Int,           //each class has a unique indexNumber
    @ColumnInfo(name = "subject") val subject: String,  //CSCI
    @ColumnInfo(name = "number") val number: Int,       //5115
    @ColumnInfo(name = "teacher_name") val teacherName: String? //e.g. Loren
)

@Dao
interface UserDao {
    @Query("SELECT * FROM course")
    fun getAll(): List<Course>

    @Query("SELECT * FROM course WHERE indexNumber IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Course>

    @Query("SELECT * FROM course WHERE course_name LIKE :first AND " +
            "teacher_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Course

    @Insert
    fun insertAll(vararg users: Course)

    @Delete
    fun delete(user: Course)
}

@Database(entities = arrayOf(Course::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}