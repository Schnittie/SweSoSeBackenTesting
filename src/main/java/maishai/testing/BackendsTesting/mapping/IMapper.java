package maishai.testing.BackendsTesting.mapping;

public interface IMapper <E,T> {
    T fromInToOut(E entity);
    E fromOutToIn(T to);
}
