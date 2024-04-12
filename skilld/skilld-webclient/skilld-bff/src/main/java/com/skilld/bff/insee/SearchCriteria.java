package com.skilld.bff.insee;

record SearchCriteria(SearchVariable searchVar, String value, SearchOperator operator) {

    static SearchCriteria from(SearchVariable searchVar, String value, SearchOperator operator) {
        return new SearchCriteria(searchVar, value, operator);
    }

    static SearchCriteria from(SearchVariable searchVar, String value) {
        return new SearchCriteria(searchVar, value, SearchOperator.NONE);
    }

    static SearchCriteria simpleSearch(String value) {
        return new SearchCriteria(SearchVariable.COMPANY_NAME, value, SearchOperator.NONE);
    }

    @Override
    public String toString() {
        String stringified = String.join(":", searchVar().getSearchVariable(), value());

        return SearchOperator.NONE.equals(this.operator()) ?
                stringified :
                stringified + " " + operator();
    }
}