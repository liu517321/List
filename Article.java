public class Article {
    String title;
    String author;
    String content;
    String publishedAt;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Article)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Article a = (Article)obj;
        if (!title.equals(a.title)) {
            return false;
        }

        if (!author.equals(a.author)) {
            return false;
        }

        if (!content.equals(a.content)) {
            return false;
        }

        return publishedAt.equals(a.publishedAt);
    }
}
