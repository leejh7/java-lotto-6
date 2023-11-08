package lotto.model;

import lotto.constant.LotteryRank;

public class LottoMachine {
    private Lotto winningLotto;

    private int bonusNumber;

    public LottoMachine(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    /**
     * 로또 회사에서 player의 당첨 등수가 올바른지 확인하는 메서드
     */
    public boolean checkLotteryRank(Lotto playerLotto, LotteryRank playerLotteryRank) {
        int matchingNumbersCount = winningLotto.matchingNumbersCount(playerLotto);
        boolean containsBonusNumber = playerLotto.containsNumber(bonusNumber);

        LotteryResult lotteryResult = new LotteryResult(matchingNumbersCount, containsBonusNumber);

        return playerLotteryRank == LotteryRank.getLotteryRank(lotteryResult);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}