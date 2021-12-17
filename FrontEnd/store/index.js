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
    set_header_token(state) {
        state.header_token = {
            headers: {
                Authorization:
                    'Bearer ' + state.token
            }
        }
    },
    isLogout(state, val) {
        state.isLogged = false
    },
    isLogin(state, val) {
        state.isLogged = false
    },
    adminLogged(state, val) {
        state.isAdmin = true
    },
    adminLogout(state, val) {
        state.isAdmin = false
    },

}