class ArticlesController < ApplicationController
<<<<<<< HEAD
	def new
	
	end
  def create
  end
end
=======
  http_basic_authenticate_with name: "dhh", password: "secret", except: [:index, :show]


  def new
   @article = Article.new
 end

 def create
    #render plain: params[:article].inspect
    @article = Article.new(article_params)

    if @article.save
      redirect_to @article
    else
      render 'new'
    end
  end


  def show
    @article = Article.find(params[:id])
  end


  def index
    @articles = Article.all
  end


  def edit
    @article = Article.find(params[:id])
  end


  def update
    @article = Article.find(params[:id])

    if @article.update(article_params)
      redirect_to @article
    else
      render 'edit'
    end
  end


  def destroy
    @article = Article.find(params[:id])
    @article.destroy

    redirect_to articles_path
  end


  private
  def article_params
    params.require(:article).permit(:title, :text)
  end
end


>>>>>>> 5ded200b0804c19e0f189503805afadd2104f0e1
