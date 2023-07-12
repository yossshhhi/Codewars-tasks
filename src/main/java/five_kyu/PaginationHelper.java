package five_kyu;

import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {

    private final List<I> collection;
    private final int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int completedPage = itemCount() / itemsPerPage;
        return itemCount() % itemsPerPage != 0 ? completedPage + 1 : completedPage;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex + 1 > pageCount() || pageIndex < 0) return -1;
        if (pageIndex + 1 < pageCount()) return itemsPerPage;
        return itemCount() - (pageCount() - 1) * itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex + 1 > itemCount() || collection.isEmpty()) return -1;
        return itemIndex / itemsPerPage;
    }
}
