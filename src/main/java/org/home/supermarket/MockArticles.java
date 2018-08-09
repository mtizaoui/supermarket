package org.home.supermarket;

public class MockArticles {

	
	private ArticleManager articleFactory = new ArticleManager();
	private Article article0 = articleFactory.article(1.0);
	private Article article1 = articleFactory.article(1.5);
	
    private static MockArticles instance;
    
    private MockArticles(){}
    
    public static MockArticles getInstance(){
        if(instance == null){
            instance = new MockArticles();
        }
        return instance;
    }

	public Article getArticle0() {
		return article0;
	}

	public void setArticle0(Article article0) {
		this.article0 = article0;
	}

	public Article getArticle1() {
		return article1;
	}

	public void setArticle1(Article article1) {
		this.article1 = article1;
	}
    
    
}