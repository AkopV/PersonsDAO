package org.sourceit.db;

import java.util.List;

/**
 * ���������, ������� ������������� �� CRUD(https://ru.wikipedia.org/wiki/CRUD)
 * @param <T> ����� ������ �������� ������������.
 */
public interface DAO<T> {

    /**
     * ������� �������� � ���� ������.
     * @param entity ���������
     * @return �������� ��� ���.
     */
    boolean create(T entity);

    /**
     * ��������� ������ ��������
     * @return ���������� ��� ���.
     */
    boolean update(T entity);

    /**
     * ������ ���������.
     * @return
     */
    List<T> list();

    /**
     * ������� ������ ��������.
     * @param entity ��������� �� �������, ����� �������.
     * @return ��������� ��� ���.
     */
    boolean remove(T entity);

}
