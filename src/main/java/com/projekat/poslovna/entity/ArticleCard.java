package com.projekat.poslovna.entity;
/**
 * Klasa koja predstavlja robnu karticu.
 * Robna kartica je vezana za jednu robu u jednoj fiskalnoj godini u jednom magacinu.
 * Za novac koristimo tip BigDecimal jer: https://stackoverflow.com/questions/3413448/double-vs-bigdecimal
 * Tabela u bazi bi trebala imati samo jednu n-torku ovog tipa koja se gazi svaki put kad se menja stanje.
 * Za detalje oko svake promene brine se Analitika Magacinske Kartice (ArticleCardAnalytics)
 * @author alowishusad
 *
 */

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ArticleCard {
	// TODO resi mapiranje tipova , treba koristiti money
	// TODO ova tabela sme imati samo jedan jedini red u nekom trenutku, jedan ili nijedan u nekim situacijama
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable= false, precision=10, scale=2)
	private BigDecimal price;

	@Column
	private int startStateQuantity;
	@Column(nullable= false, precision=10, scale=2)
	private BigDecimal startStateValue;

	@Column
	private int inQuantity;
	@Column(nullable= false, precision=10, scale=2)
	private BigDecimal inValue;

	@Column
	private int outQuantity;
	@Column(nullable= false, precision=10, scale=2)
	private BigDecimal outValue;

	@Column
	private int sumQuantity;
	@Column(nullable= false, precision=10, scale=2)
	private BigDecimal sumValue;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Article article;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private FiscalYear fiscalYear;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Warehouse warehouse;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="articleCard")
	private Set<ArticleCardAnalytics> articleCardAnalytics = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStartStateQuantity() {
		return startStateQuantity;
	}

	public void setStartStateQuantity(int startStateQuantity) {
		this.startStateQuantity = startStateQuantity;
	}

	public BigDecimal getStartStateValue() {
		return startStateValue;
	}

	public void setStartStateValue(BigDecimal startStateValue) {
		this.startStateValue = startStateValue;
	}

	public int getInQuantity() {
		return inQuantity;
	}

	public void setInQuantity(int inQuantity) {
		this.inQuantity = inQuantity;
	}

	public BigDecimal getInValue() {
		return inValue;
	}

	public void setInValue(BigDecimal inValue) {
		this.inValue = inValue;
	}

	public int getOutQuantity() {
		return outQuantity;
	}

	public void setOutQuantity(int outQuantity) {
		this.outQuantity = outQuantity;
	}

	public BigDecimal getOutValue() {
		return outValue;
	}

	public void setOutValue(BigDecimal outValue) {
		this.outValue = outValue;
	}

	public int getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(int sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public BigDecimal getSumValue() {
		return sumValue;
	}

	public void setSumValue(BigDecimal sumValue) {
		this.sumValue = sumValue;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public FiscalYear getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(FiscalYear fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Set<ArticleCardAnalytics> getArticleCardAnalytics() {
		return articleCardAnalytics;
	}

	public void setArticleCardAnalytics(Set<ArticleCardAnalytics> articleCardAnalytics) {
		this.articleCardAnalytics = articleCardAnalytics;
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ArticleCard)) {
            return false;
        }
        ArticleCard articleCard = (ArticleCard) o;
        return id == articleCard.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
