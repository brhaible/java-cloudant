package com.cloudant.client.api;

import org.lightcouch.CouchDatabaseBase;
import org.lightcouch.Page;
import org.lightcouch.ViewResult;

import java.io.InputStream;
import java.util.List;

/**
 * This class provides access to the <tt>View</tt> APIs.
 * <p/>
 * <h3>Usage Example:</h3>
 * <pre>
 * {@code
 *  List<Foo> list = db.view("example/foo")
 * 	.startKey("start-key")
 * 	.endKey("end-key")
 * 	.limit(10)
 * 	.includeDocs(true)
 * 	.query(Foo.class);
 *
 *  // scalar values
 *  int count = db.view("example/by_tag")
 * 	.key("couchdb")
 * 	.queryForInt();
 *
 * // pagination
 * Page<Foo> page = db.view("example/foo").queryPage(...);
 * }
 * </pre>
 *
 * @author Ganesh K Choudhary
 * @see CouchDatabaseBase#view(String)
 * @see ViewResult
 * @since 0.0.1
 */
public class View {
    private org.lightcouch.View view;

    /**
     * @return the view
     */
    org.lightcouch.View getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    void setView(org.lightcouch.View view) {
        this.view = view;
    }

    /**
     * Queries a view as an {@link InputStream}
     * <p>The stream should be properly closed after usage, as to avoid connection leaks.
     *
     * @return The result as an {@link InputStream}.
     */
    public InputStream queryForStream() {
        return view.queryForStream();
    }

    /**
     * Queries a view.
     *
     * @param <T>      Object type T
     * @param classOfT The class of type T
     * @return The result of the view query as a {@code List<T> }
     */
    public <T> List<T> query(Class<T> classOfT) {
        return view.query(classOfT);
    }

    /**
     * Queries a view.
     *
     * @param <K>      Object type K (key)
     * @param <V>      Object type V (value)
     * @param classOfK The class of type K.
     * @param classOfV The class of type V.
     * @param classOfT The class of type T.
     * @return The View result entries.
     */
    public <K, V, T> com.cloudant.client.api.model.ViewResult<K, V, T> queryView(Class<K> classOfK,
                                                                                 Class<V>
                                                                                         classOfV, Class<T> classOfT) {
        ViewResult<K, V, T> lightCouchQueryView = view.queryView(classOfK, classOfV, classOfT);
        com.cloudant.client.api.model.ViewResult<K, V, T> queryView = new com.cloudant.client.api
                .model.ViewResult<K, V, T>(lightCouchQueryView);
        return queryView;
    }

    /**
     * @return The result of the view as int.
     */
    public int queryForInt() {
        return view.queryForInt();
    }

    /**
     * @return The result of the view as boolean.
     */
    public boolean queryForBoolean() {
        return view.queryForBoolean();
    }

    /**
     * @param key The key value, accepts a single value or multiple values for complex keys.
     */
    public View key(Object... key) {
        this.view = view.key(key);
        return this;
    }

    /**
     * @param startKey The start key value, accepts a single value or multiple values for complex
     *                    keys.
     */
    public View startKey(Object... startKey) {
        this.view = view.startKey(startKey);
        return this;
    }

    /**
     * @param startKeyDocId
     * @return
     */
    public View startKeyDocId(String startKeyDocId) {
        this.view = view.startKeyDocId(startKeyDocId);
        return this;
    }

    /**
     * @param endKey The end key value, accepts a single value or multiple values for complex keys.
     */
    public View endKey(Object... endKey) {
        this.view = view.endKey(endKey);
        return this;
    }

    /**
     * @param endKeyDocId
     * @return
     */
    public View endKeyDocId(String endKeyDocId) {
        this.view = view.endKeyDocId(endKeyDocId);
        return this;
    }

    /**
     * Reverses the reading direction, not the sort order.
     */
    public View descending(Boolean descending) {
        this.view = view.descending(descending);
        return this;
    }

    /**
     * @return The result of the view as String.
     */
    public String queryForString() {
        return view.queryForString();
    }

    /**
     * @param limit
     * @return
     */
    public View limit(Integer limit) {
        this.view = view.limit(limit);
        return this;
    }

    /**
     * @param group Specifies whether the reduce function reduces the result to a set of keys,
     *              or to a single result. Defaults to false (single result).
     */
    public View group(Boolean group) {
        this.view = view.group(group);
        return this;
    }

    /**
     * @param groupLevel
     * @return
     */
    public View groupLevel(Integer groupLevel) {
        this.view = view.groupLevel(groupLevel);
        return this;
    }


    /**
     * @return The result of the view as long.
     */
    public long queryForLong() {
        return view.queryForLong();
    }

    /**
     * Queries a view for pagination, returns a next or a previous page, this method
     * figures out which page to return based on the given param that is generated by an
     * earlier call to this method, quering the first page is done by passing a {@code null} param.
     *
     * @param <T>         Object type T
     * @param rowsPerPage The number of rows per page.
     * @param param       The request parameter to use to query a page, or {@code null} to return
     *                       the first page.
     * @param classOfT    The class of type T.
     * @return {@link Page}
     */
    public <T> com.cloudant.client.api.model.Page<T> queryPage(int rowsPerPage, String param,
                                                               Class<T> classOfT) {
        Page<T> lightCouchPage = view.queryPage(rowsPerPage, param, classOfT);
        com.cloudant.client.api.model.Page<T> page = new com.cloudant.client.api.model.Page<T>
                (lightCouchPage);
        return page;
    }

    /**
     * @param stale Accept values: ok | update_after (update_after as of CouchDB 1.1.0)
     */
    public View stale(String stale) {
        this.view = view.stale(stale);
        return this;
    }

    /**
     * @param skip Skips <i>n</i> number of documents.
     */
    public View skip(Integer skip) {
        this.view = view.skip(skip);
        return this;
    }

    /**
     * @param reduce Indicates whether to use the reduce function of the view,
     *               defaults to true if the reduce function is defined.
     */
    public View reduce(Boolean reduce) {
        this.view = view.reduce(reduce);
        return this;
    }

    /**
     * @param includeDocs
     * @return
     */
    public View includeDocs(Boolean includeDocs) {
        this.view = view.includeDocs(includeDocs);
        return this;
    }

    /**
     * @param inclusiveEnd Indicates whether the endkey is included in the result,
     *                     defaults to true.
     */
    public View inclusiveEnd(Boolean inclusiveEnd) {
        this.view = view.inclusiveEnd(inclusiveEnd);
        return this;
    }

    /**
     * @param updateSeq
     * @return
     */
    public View updateSeq(Boolean updateSeq) {
        this.view = view.updateSeq(updateSeq);
        return this;
    }

    /**
     * Supplies a key list when calling <tt>_all_docs</tt> View.
     *
     * @param keys
     * @return
     */
    public View keys(Object... keys) {
        this.view = view.keys(keys);
        return this;
    }


}
