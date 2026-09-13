for i in `seq 100`; do
    R=$(($RANDOM % 991 + 10))

    for j in `seq $R`; do
        echo -n "$(($RANDOM % 20)) "
    done

    echo
done