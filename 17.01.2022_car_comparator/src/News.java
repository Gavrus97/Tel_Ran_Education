public class News implements Comparable<News>{

    String text;
    int priority;

    public News(String text, int priority) {
        this.text = text;
        this.priority = priority;
    }

    @Override
    public int compareTo(News o) {
        if (this.priority == o.priority)
            return this.text.length() - o.text.length();
        return o.priority - this.priority;
    }
}
