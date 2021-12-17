export const state = () => ({
    header_token: {},
    token: "",
    isLogged: false,
    isAdmin: false
})

export const mutations = {
    set_token(state, val) {
        //console.log("set state: " + val);
        state.token = val
    },
    set_header_token(state, token) {
        state.header_token = {
            headers: {
                Authorization:
                    'Bearer ' + token
            }
        }
    },
    isLogin(state) {
        state.isLogged = true
    },
    isLogout(state) {
        state.isLogged = false
    },

    adminLogged(state) {
        state.isAdmin = true
    },
    adminLogout(state) {
        state.isAdmin = false
    },

}