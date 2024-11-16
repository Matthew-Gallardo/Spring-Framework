/*
 * This file is generated by jOOQ.
 */
package org.acumen.training.codes.model.tables;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.acumen.training.codes.model.Keys;
import org.acumen.training.codes.model.Public;
import org.acumen.training.codes.model.tables.Boat.BoatPath;
import org.acumen.training.codes.model.tables.Sailor.SailorPath;
import org.acumen.training.codes.model.tables.records.ReservationRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Reservation extends TableImpl<ReservationRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.reservation</code>
     */
    public static final Reservation RESERVATION = new Reservation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReservationRecord> getRecordType() {
        return ReservationRecord.class;
    }

    /**
     * The column <code>public.reservation.rid</code>.
     */
    public final TableField<ReservationRecord, Integer> RID = createField(DSL.name("rid"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.reservation.sid</code>.
     */
    public final TableField<ReservationRecord, Integer> SID = createField(DSL.name("sid"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.reservation.bid</code>.
     */
    public final TableField<ReservationRecord, Integer> BID = createField(DSL.name("bid"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.reservation.day</code>.
     */
    public final TableField<ReservationRecord, LocalDate> DAY = createField(DSL.name("day"), SQLDataType.LOCALDATE.nullable(false), this, "");

    private Reservation(Name alias, Table<ReservationRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Reservation(Name alias, Table<ReservationRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.reservation</code> table reference
     */
    public Reservation(String alias) {
        this(DSL.name(alias), RESERVATION);
    }

    /**
     * Create an aliased <code>public.reservation</code> table reference
     */
    public Reservation(Name alias) {
        this(alias, RESERVATION);
    }

    /**
     * Create a <code>public.reservation</code> table reference
     */
    public Reservation() {
        this(DSL.name("reservation"), null);
    }

    public <O extends Record> Reservation(Table<O> path, ForeignKey<O, ReservationRecord> childPath, InverseForeignKey<O, ReservationRecord> parentPath) {
        super(path, childPath, parentPath, RESERVATION);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ReservationPath extends Reservation implements Path<ReservationRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> ReservationPath(Table<O> path, ForeignKey<O, ReservationRecord> childPath, InverseForeignKey<O, ReservationRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ReservationPath(Name alias, Table<ReservationRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ReservationPath as(String alias) {
            return new ReservationPath(DSL.name(alias), this);
        }

        @Override
        public ReservationPath as(Name alias) {
            return new ReservationPath(alias, this);
        }

        @Override
        public ReservationPath as(Table<?> alias) {
            return new ReservationPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<ReservationRecord> getPrimaryKey() {
        return Keys.RESERVATION_PKEY;
    }

    @Override
    public List<ForeignKey<ReservationRecord, ?>> getReferences() {
        return Arrays.asList(Keys.RESERVATION__RESERVATION_BID_FKEY, Keys.RESERVATION__RESERVATION_SID_FKEY);
    }

    private transient BoatPath _boat;

    /**
     * Get the implicit join path to the <code>public.boat</code> table.
     */
    public BoatPath boat() {
        if (_boat == null)
            _boat = new BoatPath(this, Keys.RESERVATION__RESERVATION_BID_FKEY, null);

        return _boat;
    }

    private transient SailorPath _sailor;

    /**
     * Get the implicit join path to the <code>public.sailor</code> table.
     */
    public SailorPath sailor() {
        if (_sailor == null)
            _sailor = new SailorPath(this, Keys.RESERVATION__RESERVATION_SID_FKEY, null);

        return _sailor;
    }

    @Override
    public Reservation as(String alias) {
        return new Reservation(DSL.name(alias), this);
    }

    @Override
    public Reservation as(Name alias) {
        return new Reservation(alias, this);
    }

    @Override
    public Reservation as(Table<?> alias) {
        return new Reservation(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Reservation rename(String name) {
        return new Reservation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Reservation rename(Name name) {
        return new Reservation(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Reservation rename(Table<?> name) {
        return new Reservation(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reservation where(Condition condition) {
        return new Reservation(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reservation where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reservation where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reservation where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Reservation where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Reservation where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Reservation where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Reservation where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reservation whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reservation whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
