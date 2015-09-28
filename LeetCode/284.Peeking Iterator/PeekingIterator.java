class PeekingIterator implements Iterator<Integer> {
    int next;
    boolean validNext;
    Iterator<Integer> iter;
    public PeekingIterator (Iterator<Integer> iterator) {
        this.iter = iterator;
        if (this.iter.hasNext()) {
            next = iter.next();
            validNext = true;
        } else {
            validNext = false;
        }
    }

    public Integer peek() {
        if (validNext) {
            return next;
        }
        return null;
    }

    @Override
    public Integer next() {
        if (validNext) {
            if (iter.hasNext()) {
                next = iter.next();
            } else {
                validNext = false;
            }
            return next;
        }

        return null;
    }

    @Override
    public boolean hasNext() {
        reuturn validNext;
    }
}