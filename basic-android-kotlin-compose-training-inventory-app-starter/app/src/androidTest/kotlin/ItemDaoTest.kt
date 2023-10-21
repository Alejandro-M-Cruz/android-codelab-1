import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.inventory.data.InventoryDatabase
import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class ItemDaoTest {
    private lateinit var itemDao: ItemDao
    private lateinit var db: InventoryDatabase
    private var item1 = Item(1, "Apples", 10.0, 20)
    private var item2 = Item(2, "Bananas", 15.0, 97)

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        db = Room
            .inMemoryDatabaseBuilder(context, InventoryDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        itemDao = db.itemDao()
    }

    @Test
    @Throws(Exception::class)
    fun daoInsert_insertsItemIntoDb() = runBlocking {
        addOneItemToDb()
        val allItems = itemDao.getAll().first()
        assertEquals(allItems[0], item1)
    }

    @Test
    @Throws(Exception::class)
    fun daoGetAll_returnsAllItemsInDb() = runBlocking {
        addTwoItemsToDb()
        val allItems = itemDao.getAll().first()
        assertEquals(allItems, listOf(item1, item2))
    }

    @Test
    @Throws(Exception::class)
    fun daoGet_returnsItemInDb() = runBlocking {
        addTwoItemsToDb()
        assertEquals(itemDao.get(item2.id).first(), item2)
        assertEquals(itemDao.get(item1.id).first(), item1)
    }

    @Test
    @Throws(Exception::class)
    fun daoUpdate_updatesItemsInDb() = runBlocking {
        addTwoItemsToDb()
        val updatedItem1 = item1.copy(name = "Oranges")
        itemDao.update(updatedItem1)
        assertEquals(itemDao.get(item1.id).first(), updatedItem1)
        val updatedItem2 = item2.copy(quantity = 100)
        itemDao.update(updatedItem2)
        assertEquals(itemDao.get(item2.id).first(), updatedItem2)
    }

    @Test
    @Throws(Exception::class)
    fun daoDelete_deletesItemInDb() = runBlocking {
        addTwoItemsToDb()
        itemDao.delete(item1)
        assertEquals(itemDao.getAll().first(), listOf(item2))
        itemDao.delete(item2)
        assertTrue(itemDao.getAll().first().isEmpty())
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    private suspend fun addOneItemToDb() {
        itemDao.insert(item1)
    }

    private suspend fun addTwoItemsToDb() {
        itemDao.insert(item1)
        itemDao.insert(item2)
    }
}