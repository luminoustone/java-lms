package nextstep.qna.domain;

import static org.assertj.core.api.Assertions.*;

import nextstep.qna.CannotDeleteException;
import nextstep.users.domain.NsUserTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnswerTest {
    public static final Answer A1 = new Answer(NsUserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents1");
    public static final Answer A2 = new Answer(NsUserTest.SANJIGI, QuestionTest.Q1, "Answers Contents2");

    @Test
    void deleteError() {
        assertThatThrownBy(() -> A1.deleteBy(NsUserTest.SANJIGI))
            .isInstanceOf(CannotDeleteException.class);
    }

    @Test
    void deleteAnswer() throws CannotDeleteException {
        A1.deleteBy(NsUserTest.JAVAJIGI);
        assertThat(A1.isDeleted()).isTrue();
    }
}
