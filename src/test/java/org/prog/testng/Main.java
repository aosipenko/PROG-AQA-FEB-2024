import java.util.List;
import java.util.ArrayList;

class SearchPage {
    private int currentPage;
    private List<String> searchResults;

    public SearchPage(int currentPage) {
        this.currentPage = currentPage;
        this.searchResults = new ArrayList<>();
    }

    public void left() {
        if (currentPage > 1) {
            currentPage--;
        }
    }

    public void right() {
        currentPage++;
    }

    public void goToPage(int page) {
        currentPage = page;
    }

    public void addResult(String result) {
        searchResults.add(result);
    }

    public boolean containsValue(String value) {
        return searchResults.stream().anyMatch(result -> result.contains(value));
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public List<String> getSearchResults() {
        return searchResults;
    }
}
public class Main {
    public static void main(String[] args) {

        SearchPage page = new SearchPage(1);

        // Add search results to the current page
        page.addResult("Result 1");
        page.addResult("Result 2");
        page.addResult("Searched Value");

        // Check if the searched value is present on the current page
        System.out.println("Does the page contain the searched value? " + page.containsValue("Searched Value"));

        // Navigate between search pages
        page.right();
        System.out.println("Current page: " + page.getCurrentPage());

        page.left();
        System.out.println("Current page: " + page.getCurrentPage());

        page.goToPage(5);
        System.out.println("Current page: " + page.getCurrentPage());
    }
}
